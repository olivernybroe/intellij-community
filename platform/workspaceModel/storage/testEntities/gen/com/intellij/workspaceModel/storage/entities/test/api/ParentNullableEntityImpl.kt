package com.intellij.workspaceModel.storage.entities.test.api

import com.intellij.workspaceModel.storage.EntityInformation
import com.intellij.workspaceModel.storage.EntitySource
import com.intellij.workspaceModel.storage.EntityStorage
import com.intellij.workspaceModel.storage.GeneratedCodeApiVersion
import com.intellij.workspaceModel.storage.GeneratedCodeImplVersion
import com.intellij.workspaceModel.storage.ModifiableWorkspaceEntity
import com.intellij.workspaceModel.storage.MutableEntityStorage
import com.intellij.workspaceModel.storage.WorkspaceEntity
import com.intellij.workspaceModel.storage.impl.ConnectionId
import com.intellij.workspaceModel.storage.impl.ExtRefKey
import com.intellij.workspaceModel.storage.impl.ModifiableWorkspaceEntityBase
import com.intellij.workspaceModel.storage.impl.WorkspaceEntityBase
import com.intellij.workspaceModel.storage.impl.WorkspaceEntityData
import com.intellij.workspaceModel.storage.impl.extractOneToOneChild
import com.intellij.workspaceModel.storage.impl.updateOneToOneChildOfParent
import org.jetbrains.deft.ObjBuilder
import org.jetbrains.deft.Type
import org.jetbrains.deft.annotations.Child

@GeneratedCodeApiVersion(0)
@GeneratedCodeImplVersion(0)
open class ParentNullableEntityImpl: ParentNullableEntity, WorkspaceEntityBase() {
    
    companion object {
        internal val CHILD_CONNECTION_ID: ConnectionId = ConnectionId.create(ParentNullableEntity::class.java, ChildNullableEntity::class.java, ConnectionId.ConnectionType.ONE_TO_ONE, false)
    }
        
    @JvmField var _parentData: String? = null
    override val parentData: String
        get() = _parentData!!
                        
    override val child: ChildNullableEntity?
        get() = snapshot.extractOneToOneChild(CHILD_CONNECTION_ID, this)

    class Builder(val result: ParentNullableEntityData?): ModifiableWorkspaceEntityBase<ParentNullableEntity>(), ParentNullableEntity.Builder {
        constructor(): this(ParentNullableEntityData())
        
        override fun applyToBuilder(builder: MutableEntityStorage) {
            if (this.diff != null) {
                if (existsInBuilder(builder)) {
                    this.diff = builder
                    return
                }
                else {
                    error("Entity ParentNullableEntity is already created in a different builder")
                }
            }
            
            this.diff = builder
            this.snapshot = builder
            addToBuilder()
            this.id = getEntityData().createEntityId()
            
            val __child = _child
            if (__child != null && __child is ModifiableWorkspaceEntityBase<*>) {
                builder.addEntity(__child)
                applyRef(CHILD_CONNECTION_ID, __child)
                this._child = null
            }
            // Process entities from extension fields
            val keysToRemove = ArrayList<ExtRefKey>()
            for ((key, entity) in extReferences) {
                if (!key.isChild()) {
                    continue
                }
                if (entity is List<*>) {
                    for (item in entity) {
                        if (item is ModifiableWorkspaceEntityBase<*>) {
                            builder.addEntity(item)
                        }
                    }
                    entity as List<WorkspaceEntity>
                    val (withBuilder_entity, woBuilder_entity) = entity.partition { it is ModifiableWorkspaceEntityBase<*> && it.diff != null }
                    applyRef(key.getConnectionId(), withBuilder_entity)
                    keysToRemove.add(key)
                }
                else {
                    entity as WorkspaceEntity
                    builder.addEntity(entity)
                    applyRef(key.getConnectionId(), entity)
                    keysToRemove.add(key)
                }
            }
            for (key in keysToRemove) {
                extReferences.remove(key)
            }
            
            // Adding parents and references to the parent
            val parentKeysToRemove = ArrayList<ExtRefKey>()
            for ((key, entity) in extReferences) {
                if (key.isChild()) {
                    continue
                }
                if (entity is List<*>) {
                    error("Cannot have parent lists")
                }
                else {
                    entity as WorkspaceEntity
                    builder.addEntity(entity)
                    applyParentRef(key.getConnectionId(), entity)
                    parentKeysToRemove.add(key)
                }
            }
            for (key in parentKeysToRemove) {
                extReferences.remove(key)
            }
            checkInitialization() // TODO uncomment and check failed tests
        }
    
        fun checkInitialization() {
            val _diff = diff
            if (!getEntityData().isParentDataInitialized()) {
                error("Field ParentNullableEntity#parentData should be initialized")
            }
            if (!getEntityData().isEntitySourceInitialized()) {
                error("Field ParentNullableEntity#entitySource should be initialized")
            }
        }
    
        
        override var parentData: String
            get() = getEntityData().parentData
            set(value) {
                checkModificationAllowed()
                getEntityData().parentData = value
                changedProperty.add("parentData")
            }
            
        override var entitySource: EntitySource
            get() = getEntityData().entitySource
            set(value) {
                checkModificationAllowed()
                getEntityData().entitySource = value
                changedProperty.add("entitySource")
                
            }
            
        var _child: ChildNullableEntity? = null
        override var child: ChildNullableEntity?
            get() {
                val _diff = diff
                return if (_diff != null) {
                    _diff.extractOneToOneChild(CHILD_CONNECTION_ID, this) ?: _child
                } else {
                    _child
                }
            }
            set(value) {
                checkModificationAllowed()
                val _diff = diff
                if (_diff != null && value is ModifiableWorkspaceEntityBase<*> && value.diff == null) {
                    // Back reference for a reference of non-ext field
                    if (value is ChildNullableEntityImpl.Builder) {
                        value._parentEntity = this
                    }
                    // else you're attaching a new entity to an existing entity that is not modifiable
                    _diff.addEntity(value)
                }
                if (_diff != null && (value !is ModifiableWorkspaceEntityBase<*> || value.diff != null)) {
                    _diff.updateOneToOneChildOfParent(CHILD_CONNECTION_ID, this, value)
                }
                else {
                    // Back reference for a reference of non-ext field
                    if (value is ChildNullableEntityImpl.Builder) {
                        value._parentEntity = this
                    }
                    // else you're attaching a new entity to an existing entity that is not modifiable
                    
                    this._child = value
                }
                changedProperty.add("child")
            }
        
        override fun getEntityData(): ParentNullableEntityData = result ?: super.getEntityData() as ParentNullableEntityData
        override fun getEntityClass(): Class<ParentNullableEntity> = ParentNullableEntity::class.java
    }
}
    
class ParentNullableEntityData : WorkspaceEntityData<ParentNullableEntity>() {
    lateinit var parentData: String

    fun isParentDataInitialized(): Boolean = ::parentData.isInitialized

    override fun wrapAsModifiable(diff: MutableEntityStorage): ModifiableWorkspaceEntity<ParentNullableEntity> {
        val modifiable = ParentNullableEntityImpl.Builder(null)
        modifiable.allowModifications {
          modifiable.diff = diff
          modifiable.snapshot = diff
          modifiable.id = createEntityId()
          modifiable.entitySource = this.entitySource
        }
        return modifiable
    }

    override fun createEntity(snapshot: EntityStorage): ParentNullableEntity {
        val entity = ParentNullableEntityImpl()
        entity._parentData = parentData
        entity.entitySource = entitySource
        entity.snapshot = snapshot
        entity.id = createEntityId()
        return entity
    }

    override fun getEntityInterface(): Class<out WorkspaceEntity> {
        return ParentNullableEntity::class.java
    }

    override fun serialize(ser: EntityInformation.Serializer) {
    }

    override fun deserialize(de: EntityInformation.Deserializer) {
    }

    override fun equals(other: Any?): Boolean {
        if (other == null) return false
        if (this::class != other::class) return false
        
        other as ParentNullableEntityData
        
        if (this.parentData != other.parentData) return false
        if (this.entitySource != other.entitySource) return false
        return true
    }

    override fun equalsIgnoringEntitySource(other: Any?): Boolean {
        if (other == null) return false
        if (this::class != other::class) return false
        
        other as ParentNullableEntityData
        
        if (this.parentData != other.parentData) return false
        return true
    }

    override fun hashCode(): Int {
        var result = entitySource.hashCode()
        result = 31 * result + parentData.hashCode()
        return result
    }
}