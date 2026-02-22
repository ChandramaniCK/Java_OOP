import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student("KRG20281", "Alice", 0, 0);
        Student s2 = new Student("STD10001", "Bob", 50, 0);
        Student s3 = new Student("STD10002", "Charlie", 0, 2);

        HashMap<String, Student> students = new HashMap<>();
        students.put(s1.getUid(), s1);
        students.put(s2.getUid(), s2);
        students.put(s3.getUid(), s3);
        AssetStore store = new AssetStore();
        store.addAsset(new Asset("LAB-101", "HDMI Cable", true, 1));
        store.addAsset(new Asset("LAB-102", "Projector", true, 2));
        store.addAsset(new Asset("LAB-103", "Secure Laptop", true, 3));

        CheckoutService service = new CheckoutService(store, students);

        CheckoutRequest r1 = new CheckoutRequest("KRG20281", "LAB-101", 4); 
        CheckoutRequest r2 = new CheckoutRequest("STD10001", "LAB-999", 2); 
        CheckoutRequest r3 = new CheckoutRequest("STD10002", "LAB-102", 2); 

        CheckoutRequest[] requests = {r1, r2, r3};

        for (CheckoutRequest req : requests) {
            try {
                String receipt = service.checkout(req);
                System.out.println("Checkout successful: " + receipt);
            } catch (IllegalArgumentException e) {
                AuditLogger.logError(e);
            } catch (NullPointerException e) {
                AuditLogger.logError(e);
            } catch (SecurityException e) {
                AuditLogger.logError(e);
            } catch (IllegalStateException e) {
                AuditLogger.logError(e);
            } finally {
                AuditLogger.log("Attempt finished for UID=" + req.getUid() + ", asset=" + req.getAssetId());
            }
        }
    }
}
