package com.example.skillcinema.presentation.firstpartpresentation

sealed class StateForPresentation{
    object Start : StateForPresentation()
    object Loading : StateForPresentation()
    object Success : StateForPresentation()
    object ErrorText : StateForPresentation(){
        var message: String = ""
    }
    object FirstTimePresentation : StateForPresentation()
    object JustLoader : StateForPresentation()



}
