package fw1;
// Purpose.  Flyweight design pattern
//
// Discussion.  Trying to use objects at very low levels of granularity is 
// nice, but the overhead may be prohibitive.  Flyweight suggests removing the
// non-shareable state from the class, and having the client supply it when
// methods are called.  This places more responsibility on the client, but,
// considerably fewer instances of the Flyweight class are now created.
// Sharing of these instances is facilitated by introducing a Factory class
// that maintains a "cache" of existing Flyweights.

class Gazillion {
   private static int num = 0;
   private int        row, col;
   public Gazillion( int maxPerRow ) {
      row = num / maxPerRow;
      col = num % maxPerRow;
      num++;
   }
   void report() {
      System.out.print( " " + row + col );
}  }

public class FlyweightDemo {
   public static final int ROWS = 6, COLS = 10;

   public static void main( String[] args ) {
      Gazillion[][] matrix = new Gazillion[ROWS][COLS];
      for (int i=0; i < ROWS; i++)
         for (int j=0; j < COLS; j++)
            matrix[i][j] = new Gazillion( COLS );
      for (int i=0; i < ROWS; i++) {
         for (int j=0; j < COLS; j++)
            matrix[i][j].report();
         System.out.println();
}  }  }


//00 01 02 03 04 05 06 07 08 09
//10 11 12 13 14 15 16 17 18 19
//20 21 22 23 24 25 26 27 28 29
//30 31 32 33 34 35 36 37 38 39
//40 41 42 43 44 45 46 47 48 49
//50 51 52 53 54 55 56 57 58 59

