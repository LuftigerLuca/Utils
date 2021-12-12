/**
 * This class is useful for calculating xp from a level and vice versa
 * @author LuftigerLuca
 * @version 1.0
 */

public class LevelCalculator {

    public static void main(String[] args) {
        System.out.println(getLevelProgress(125, 1.5, 100));
        System.out.println(getXpFromLevel(2, 1.5, 100));
    }

    /**
     *
     * This method is suitable for calculating the associated level from a specific xp value.
     *
     * @param xp the xp value for which the level is to be output
     * @param multiplier the value by which the xp points are multiplied to calculate the next level
     * @param coreValue the basic value that defines the first level
     * @return the level, which one has the given xp-number
     */
    public static double getLevelFromXp(double xp, double multiplier, double coreValue){
        return Math.floor(Math.log(xp/coreValue) / Math.log(multiplier) + 1);
    }


    /**
     * This method is useful to calculate the min. xp required for a level
     *
     * @param level the level for which the required xp value is returned
     * @param multiplier the value by which the xp points are multiplied to calculate the next level
     * @param coreValue the basic value that defines the first level
     * @return the xp required for this based on the specified level
     */
    public static double getXpFromLevel(double level, double multiplier, double coreValue){
        return coreValue * Math.pow(multiplier, level - 1);
    }

    /**
     * This method is useful to calculate the progress between 2 levels
     *
     * @param currentXp the currentXp value from which the progress to the next level should be calculated
     * @param multiplier the value by which the xp points are multiplied to calculate the next level
     * @param coreValue the basic value that defines the first level
     * @return the progress between 2 xp values, 0 being 0% and 1 being 100%
     */
   public static double getLevelProgress(double currentXp , double multiplier, double coreValue){
       double difference = (getXpFromLevel(getLevelFromXp(currentXp, multiplier, coreValue) + 1, multiplier, coreValue) - getXpFromLevel(getLevelFromXp(currentXp, multiplier, coreValue), multiplier, coreValue));
       if(difference != 0) return (currentXp - getXpFromLevel(getLevelFromXp(currentXp, multiplier, coreValue), multiplier, coreValue)) / difference;
       return 1;
    }
}
