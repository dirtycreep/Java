package task1;


public class UnitPowerComparator implements java.util.Comparator<task1.Unit>{
        public int compare(task1.Unit un1, task1.Unit un2) {
            return (un1.getUnitPower() - un2.getUnitPower());
        }

}
