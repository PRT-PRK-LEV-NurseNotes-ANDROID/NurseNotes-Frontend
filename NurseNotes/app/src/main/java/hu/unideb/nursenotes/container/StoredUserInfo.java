package hu.unideb.nursenotes.container;

public class StoredUserInfo {
    private static StoredUserInfo instance = null;
    private String InternalToken;

    public static StoredUserInfo getInstance() {
        if (instance == null) {
            instance = new StoredUserInfo();
        }
        return instance;
    }


    public String getInternalToken() {
        return InternalToken;
    }

    public void setInternalToken(String internalToken) {
        InternalToken = internalToken;
    }

}