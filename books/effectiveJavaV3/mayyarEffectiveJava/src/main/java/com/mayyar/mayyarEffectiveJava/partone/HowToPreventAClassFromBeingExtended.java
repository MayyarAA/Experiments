public class HowToPreventAClassFromBeingExtended {

    public class UtilityClass {
        // suppress default construtor fo non instantiability
        private UtilityClass() {

        }
    }
}