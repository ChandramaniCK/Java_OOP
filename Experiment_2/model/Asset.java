public class Asset {
    private String assetId;
    private String assetName;
    private boolean available;
    private int securityLevel;

    public Asset(String assetId, String assetName, boolean available, int securityLevel) {
        this.assetId = assetId;
        this.assetName = assetName;
        this.available = available;
        this.securityLevel = securityLevel;
    }

    public String getAssetId(){ 
        return assetId; 
    }
    public String getAssetName(){ 
        return assetName; 
    }
    public boolean isAvailable(){ 
        return available; 
    }
    public int getSecurityLevel(){ 
        return securityLevel; 
    }

    public void validatePolicies(String uid){
        if(!available){
            throw new IllegalStateException("Asset not available.");
        }
        if(securityLevel == 3 && !uid.startsWith("KRG")){
            throw new SecurityException("Restricted asset. UID not authorized.");
        }
    }

    public void markBorrowed() {
        if (!available) {
            throw new IllegalStateException("Asset already borrowed.");
        }
        available = false;
    }
}
