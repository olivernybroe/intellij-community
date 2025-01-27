// Copyright 2000-2022 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.
package com.intellij.workspaceModel.storage.bridgeEntities.api

import com.intellij.workspaceModel.storage.EntitySource
import com.intellij.workspaceModel.storage.ModifiableWorkspaceEntity
import com.intellij.workspaceModel.storage.WorkspaceEntityWithPersistentId
import com.intellij.workspaceModel.storage.referrersx
import org.jetbrains.deft.ObjBuilder
import org.jetbrains.deft.annotations.Child
import org.jetbrains.deft.Type
import com.intellij.workspaceModel.storage.GeneratedCodeApiVersion
import com.intellij.workspaceModel.storage.MutableEntityStorage
import com.intellij.workspaceModel.storage.impl.ExtRefKey
import com.intellij.workspaceModel.storage.impl.updateOneToManyChildrenOfParent
import com.intellij.workspaceModel.storage.impl.updateOneToOneChildOfParent
import com.intellij.workspaceModel.storage.impl.ModifiableWorkspaceEntityBase






interface FacetEntity: WorkspaceEntityWithPersistentId {
    val name: String
    val module: ModuleEntity
    val facetType: String
    val configurationXmlTag: String?
    val moduleId: ModuleId

    // underlyingFacet is a parent facet!!
    val underlyingFacet: FacetEntity?
    override val persistentId: FacetId
        get() = FacetId(name, facetType, moduleId)


    //region generated code
    //@formatter:off
    @GeneratedCodeApiVersion(0)
    interface Builder: FacetEntity, ModifiableWorkspaceEntity<FacetEntity>, ObjBuilder<FacetEntity> {
        override var name: String
        override var entitySource: EntitySource
        override var module: ModuleEntity
        override var facetType: String
        override var configurationXmlTag: String?
        override var moduleId: ModuleId
        override var underlyingFacet: FacetEntity?
    }
    
    companion object: Type<FacetEntity, Builder>() {
        operator fun invoke(name: String, entitySource: EntitySource, facetType: String, moduleId: ModuleId, init: (Builder.() -> Unit)? = null): FacetEntity {
            val builder = builder()
            builder.name = name
            builder.entitySource = entitySource
            builder.facetType = facetType
            builder.moduleId = moduleId
            init?.invoke(builder)
            return builder
        }
    }
    //@formatter:on
    //endregion

}
//region generated code
fun MutableEntityStorage.modifyEntity(entity: FacetEntity, modification: FacetEntity.Builder.() -> Unit) = modifyEntity(FacetEntity.Builder::class.java, entity, modification)
var FacetEntity.Builder.childrenFacets: @Child List<FacetEntity>
    get() {
        return referrersx(FacetEntity::underlyingFacet)
    }
    set(value) {
        val diff = (this as ModifiableWorkspaceEntityBase<*>).diff
        if (diff != null) {
            for (item in value) {
                if ((item as FacetEntityImpl.Builder).diff == null) {
                    item._underlyingFacet = this
                    diff.addEntity(item)
                }
            }
            diff.updateOneToManyChildrenOfParent(FacetEntityImpl.UNDERLYINGFACET_CONNECTION_ID, this, value)
        }
        else {
            val key = ExtRefKey("FacetEntity", "underlyingFacet", true, FacetEntityImpl.UNDERLYINGFACET_CONNECTION_ID)
            this.extReferences[key] = value
            
            for (item in value) {
                (item as FacetEntityImpl.Builder)._underlyingFacet = this
            }
        }
    }

var FacetEntity.Builder.facetExternalSystemIdEntity: @Child FacetExternalSystemIdEntity?
    get() {
        return referrersx(FacetExternalSystemIdEntity::facet).singleOrNull()
    }
    set(value) {
        val diff = (this as ModifiableWorkspaceEntityBase<*>).diff
        if (diff != null) {
            if (value != null) {
                if ((value as FacetExternalSystemIdEntityImpl.Builder).diff == null) {
                    value._facet = this
                    diff.addEntity(value)
                }
            }
            diff.updateOneToOneChildOfParent(FacetExternalSystemIdEntityImpl.FACET_CONNECTION_ID, this, value)
        }
        else {
            val key = ExtRefKey("FacetExternalSystemIdEntity", "facet", true, FacetExternalSystemIdEntityImpl.FACET_CONNECTION_ID)
            this.extReferences[key] = value
            
            if (value != null) {
                (value as FacetExternalSystemIdEntityImpl.Builder)._facet = this
            }
        }
    }

//endregion

val FacetEntity.childrenFacets: List<@Child FacetEntity>
  get() = referrersx(FacetEntity::underlyingFacet)
