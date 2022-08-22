package com.example.belgorod.app.sealed

import com.example.belgorod.data.storage.models.ObjectData
import com.example.belgorod.domain.module.ObjectDomain
import com.example.belgorod.presentation.module.ObjectPresentation

sealed class ObjectList: MainReturn() {
    class ObjectReceived(val objectList: List<ObjectData>) : ObjectList()
    class ObjectDomainReceived(val objectList: List<ObjectDomain>): ObjectList()
    class ObjectPresentationReceived(val objectList: List<ObjectPresentation>): ObjectList()
}