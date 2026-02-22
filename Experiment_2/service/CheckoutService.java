import java.time.LocalDate;

public class CheckoutService {
    private AssetStore store;
    private HashMap<String, Student> students;

    public CheckoutService(AssetStore store, HashMap<String, Student> students) {
        this.store = store;
        this.students = students;
    }

    public String checkout(CheckoutRequest req)
            throws IllegalArgumentException, IllegalStateException, SecurityException, NullPointerException {

        req.validate();

        Student s = students.get(req.getUid());
        if (s == null) throw new NullPointerException("Student not found: " + req.getUid());

        Asset a = store.findAsset(req.getAssetId());

        // Student policies
        s.validatePolicies();

        // Asset policies
        a.validatePolicies(s.getUid());

        // Realistic constraints
        int hrs = req.getHoursRequested();
        if (hrs == 6) {
            System.out.println("Note: Max duration selected. Return strictly on time.");
        }
        if (a.getAssetName().contains("Cable") && hrs > 3) {
            hrs = 3;
            System.out.println("Policy applied: Cables can be issued max 3 hours. Updated to 3.");
        }

        // Mark borrowed
        a.markBorrowed();
        s.incrementBorrowCount();

        return "TXN-" + LocalDate.now() + "-" + a.getAssetId() + "-" + s.getUid();
    }
}
