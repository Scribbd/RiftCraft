package nl.scribblon.riftcraft.reference;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 28-7-2014
 *
 * Probably not going to use this style of settings.
 */
public class SettingsObject {

    public class General {
        private boolean isAbuseProtected;
        private boolean isDeathProtected;
        private boolean isWorldProtected;

        public boolean isAbuseProtected() {
            return isAbuseProtected;
        }

        public void setAbuseProtected(boolean isAbuseProtected) {
            this.isAbuseProtected = isAbuseProtected;
        }

        public boolean isDeathProtected() {
            return isDeathProtected;
        }

        public void setDeathProtected(boolean isDeathProtected) {
            this.isDeathProtected = isDeathProtected;
        }

        public boolean isWorldProtected() {
            return isWorldProtected;
        }

        public void setWorldProtected(boolean isWorldProtected) {
            this.isWorldProtected = isWorldProtected;
        }
    }

    public class Generation {
        private boolean areStructuresGenerated;
        private boolean areRiftsRegenerating;

        public boolean areRiftsRegenerating() {
            return areRiftsRegenerating;
        }

        public void setRiftsRegenerating(boolean areRiftsRegenerating) {
            this.areRiftsRegenerating = areRiftsRegenerating;
        }

        public boolean areStructuresGenerated() {
            return areStructuresGenerated;
        }

        public void setStructuresGenerated(boolean areStructuresGenerated) {
            this.areStructuresGenerated = areStructuresGenerated;
        }
    }

    public class Conversion {
        private double euConversionRate;
        private double mjConversionRate;
        private double rfConversionRate;

        public double getEuConversionRate() {
            return euConversionRate;
        }

        public void setEuConversionRate(double euConversionRate) {
            this.euConversionRate = euConversionRate;
        }

        public double getMjConversionRate() {
            return mjConversionRate;
        }

        public void setMjConversionRate(double mjConversionRate) {
            this.mjConversionRate = mjConversionRate;
        }

        public double getRfConversionRate() {
            return rfConversionRate;
        }

        public void setRfConversionRate(double rfConversionRate) {
            this.rfConversionRate = rfConversionRate;
        }
    }

    public class Debug {
        private boolean isDebugging;

        public boolean isDebugging() {
            return isDebugging;
        }

        public void setDebugging(boolean isDebugging) {
            this.isDebugging = isDebugging;
        }
    }

}
