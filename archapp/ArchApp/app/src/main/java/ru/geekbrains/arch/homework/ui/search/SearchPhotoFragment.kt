package ru.geekbrains.arch.homework.ui.search

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import ru.geekbrains.arch.homework.R
import ru.geekbrains.arch.homework.di.Scopes
import ru.geekbrains.arch.homework.di.SearchModule
import ru.geekbrains.arch.homework.domain.Photo
import toothpick.Toothpick
import javax.inject.Inject

class SearchPhotoFragment : Fragment() {

    @Inject
    lateinit var viewModel: SearchPhotoViewModel

    private lateinit var photoAdapter: PhotoAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_search, container, false)
        val recyclerView: RecyclerView = root.findViewById(R.id.search_recycler_view)
        recyclerView.layoutManager = GridLayoutManager(context, 2)
        photoAdapter = PhotoAdapter(this)
        recyclerView.adapter = photoAdapter

        val input:EditText = root.findViewById(R.id.search_input)
        input.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                viewModel.onSearchQueryUpdated(s.toString())
            }

            override fun afterTextChanged(s: Editable?) {
            }
        })

        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val scope = Toothpick.openScopes(Scopes.APP, Scopes.SEARCH)
        scope.installModules(SearchModule())
        Toothpick.inject(this, scope)
    }

    override fun onStart() {
        super.onStart()

        viewModel.getPhotos().subscribe(object: Observer<List<Photo>> {
            override fun onSubscribe(d: Disposable) {
            }

            override fun onNext(photos: List<Photo>) {
                photoAdapter.update(photos)
            }

            override fun onError(e: Throwable) {
            }

            override fun onComplete() {
            }

        })

        viewModel.onStart()
        viewModel.onSearchQueryUpdated("")
    }

    override fun onStop() {
        super.onStop()
        viewModel.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
        Toothpick.closeScope(Scopes.SEARCH)
    }

}
