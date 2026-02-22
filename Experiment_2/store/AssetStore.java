import java.util.HashMap;

public class AssetStore {
    private HashMap<String, Asset> assets = new HashMap<>();

    public void addAsset(Asset a) {
        assets.put(a.getAssetId(), a);
    }

    public Asset findAsset(String assetId) {
        Asset a = assets.get(assetId);
        if (a == null) {
            throw new NullPointerException("Asset not found: " + assetId);
        }
        return a;
    }
}
