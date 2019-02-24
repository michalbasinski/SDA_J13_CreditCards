package pl.sda.validators;

public class ValidationResult {
    private String issuerName;
    private boolean isLuhnPassed = false;

    public String getIssuerName() {
        return issuerName;
    }

    public void setIssuerName(String issuerName) {
        this.issuerName = issuerName;
    }

    public boolean isLuhnPassed() {
        return isLuhnPassed;
    }

    public void setLuhnPassed(boolean luhnPassed) {
        isLuhnPassed = luhnPassed;
    }
}
