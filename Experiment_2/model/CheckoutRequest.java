public class CheckoutRequest {
    private String uid;
    private String assetId;
    private int hoursRequested;

    public CheckoutRequest(String uid, String assetId, int hoursRequested) {
        this.uid = uid;
        this.assetId = assetId;
        this.hoursRequested = hoursRequested;
    }

    public String getUid(){ 
        return uid; 
    }
    public String getAssetId(){ 
        return assetId; 
    }
    public int getHoursRequested(){ 
        return hoursRequested; 
    }

    public void validate(){
        ValidationUtil.validateUid(uid);
        ValidationUtil.validateAssetId(assetId);
        ValidationUtil.validateHours(hoursRequested);
    }
}
