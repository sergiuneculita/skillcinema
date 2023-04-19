package com.example.skillcinema.presentation

import com.example.skillcinema.presentation.firstpartpresentation.StateForPresentation

sealed class BaseState {
    object Presentation: BaseState()
    object Ready : BaseState()
    object ErrorText : BaseState()
}
