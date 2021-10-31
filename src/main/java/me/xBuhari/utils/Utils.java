package me.xBuhari.utils;

import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public class Utils {

    private final ConcurrentHashMap<String, DB> databaseList;

    public Utils() {
        this.databaseList = new ConcurrentHashMap<>();
    }

    public Boolean dbExist(String key) {
        return this.databaseList.containsKey(key);
    }

    public Boolean dbExist(DB db) {
        return this.databaseList.containsValue(db);
    }

    public DB getDB(String key) {
        if (dbExist(key)) {
            return this.databaseList.get(key);
        }
        return null;
    }

    public String getDB(DB db) {
        if (dbExist(db)) {
            for (Entry<String, DB> _entry : this.databaseList.entrySet()) {
                if (_entry.getValue().equals(db)) {
                    return _entry.getKey();
                }
            }
        }
        return null;
    }

    public Boolean removeDB(String key) {
        if (!dbExist(key)) {
            return false;
        }
        this.databaseList.remove(key);
        return true;
    }

    public Boolean removeDB(DB db) {
        if (!dbExist(db)) {
            return false;
        }
        this.databaseList.remove(getDB(db));
        return true;
    }

    public Boolean addDB(String key, String path) {
        if (dbExist(key)) {
            return false;
        }
        DB db = new DB(path);
        this.databaseList.put(key, db);
        return true;
    }
}
