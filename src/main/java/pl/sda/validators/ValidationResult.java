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

    @Override
    public boolean equals(Object obj) {
        ValidationResult comp = (ValidationResult) obj;

        boolean areIssuerNamesEqual = issuerName.equals(comp.getIssuerName());
        boolean areLuhnResultsEqual = isLuhnPassed == comp.isLuhnPassed;

        return areIssuerNamesEqual && areLuhnResultsEqual;
    }
}
