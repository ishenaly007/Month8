package com.abit8.lesson1month8.presentation.ui.fragments.list_of_note

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lesson1month8.domain.model.Note
import com.example.lesson1month8.domain.usecase.GetAllNoteUseCase
import com.example.lesson1month8.domain.usecase.RemoveNoteUseCase
import com.example.lesson1month8.domain.utils.Resource
import com.example.lesson1month8.presentation.base.BaseViewModel
import com.example.lesson1month8.presentation.ui.utils.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListOfNoteViewModel @Inject constructor(
    private val getAllNoteUseCase: com.example.lesson1month8.domain.usecase.GetAllNoteUseCase,
    private val removeNoteUseCase: com.example.lesson1month8.domain.usecase.RemoveNoteUseCase
) : BaseViewModel() {
    private val _getAllNoteState = MutableStateFlow<UIState<List<com.example.lesson1month8.domain.model.Note>>>(UIState.Empty())
    val getAllNoteState = _getAllNoteState.asStateFlow()

    private val _removeNoteState = MutableStateFlow<UIState<Unit>>(UIState.Empty())
    val removeNoteState = _removeNoteState.asStateFlow()

    fun getAllNotes() {
        getAllNoteUseCase.getAllNotes().collectData(_getAllNoteState)
    }
    fun removeNote(note: com.example.lesson1month8.domain.model.Note) {
        removeNoteUseCase.removeNote(note).collectData(_removeNoteState)
    }
}