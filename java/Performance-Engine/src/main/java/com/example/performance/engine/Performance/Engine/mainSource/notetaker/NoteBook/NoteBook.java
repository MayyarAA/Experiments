package com.example.performance.engine.Performance.Engine.mainSource.notetaker.NoteBook;

import com.example.performance.engine.Performance.Engine.mainSource.notetaker.BaseObject.BaseObject;
import com.example.performance.engine.Performance.Engine.mainSource.notetaker.BaseObject.ObjectHolder;
import com.example.performance.engine.Performance.Engine.mainSource.notetaker.Page.Page;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.UUID;

@Setter
@Getter
public class NoteBook extends BaseObject implements Serializable, ObjectHolder {
    String description;
    HashSet<String> admins;
    HashSet<String> viewers;
    HashSet<String> notes;
    private HashMap<String, Page> pageNameMap = new HashMap<>();
    private HashMap<UUID, Page> pageIdMap = new HashMap<>();
    String ownerId;

    public NoteBook() {

    }

    public void addAdmin(String potentialAdminId) {
        removeViewer(potentialAdminId);
        admins.add(potentialAdminId);
    }

    public void addViewer(String potentialViewerId) {
        viewers.add(potentialViewerId);
    }

    public void removeViewer(String viewerId) {
        if (viewers == null || viewers.isEmpty()) return;
        viewers.remove(viewerId);
    }

    public NoteBook(String name) {

    }

    public NoteBook(String name, String description) {
        setDescription(description);
    }

    public NoteBook(String name, String ownerId, UUID id) {
        super(name, id);
        this.ownerId = ownerId;
    }

    public NoteBook(String name, String ownerId, boolean setAdmin) {
        super(name);
        setOwnerId(ownerId);
        admins = new HashSet<>();
        admins.add(ownerId);
    }

    public boolean isAdmin(String potentialAdminId) {
        if (admins == null) return false;
        if (admins.contains(potentialAdminId)) return true;
        return false;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public BaseObject getById(int id) {

        return pageIdMap.get(id);
    }

    @Override
    public BaseObject getByName(String name) {
        return pageNameMap.get(name);
    }

    @Override
    public void addBaseObjectToMap(String baseObjectName) {

    }

    @Override
    public void removeById(int id) {
        removeFull(getById(id));
    }

    @Override
    public void removeByName(String name) {
        removeFull(getByName(name));
    }

    @Override
    public void removeFull(BaseObject baseObject) {
        pageIdMap.remove(baseObject.getCustomId());
        pageNameMap.remove(baseObject.getName());
    }
}
