package Week10;

public class BinarySearchIntArray {
    /**
     * Searches the array A for the integer N.
     * Precondition:  A must be sorted into increasing order.
     * Postcondition: If N is in the array, then the return value, i,
     *    satisfies A[i] == N.  If N is not in the array, then the
     *    return value is -1.
     */
    static int binarySearch(int[] A, int N) {

        int lowestPossibleLoc = 0;
        int highestPossibleLoc = A.length - 1;

        while (highestPossibleLoc >= lowestPossibleLoc) {
            int middle = (lowestPossibleLoc + highestPossibleLoc) / 2;
            if (A[middle] == N) {
                // N has been found at this index!
                return middle;
            }
            else if (A[middle] > N) {
                // eliminate locations >= middle
                highestPossibleLoc = middle - 1;
            }
            else {
                // eliminate locations <= middle
                lowestPossibleLoc = middle + 1;
            }
        }

        // At this point, highestPossibleLoc < lowestPossibleLoc,
        // which means that N is known to be not in the array.  Return
        // a -1 to indicate that N could not be found in the array.

        return -1;

    }

    /**
     * Search in the array A in positions numbered loIndex to hiIndex,
     * inclusive, for the specified value.  If the value is found, return
     * the index in the array where it occurs.  If the value is not found,
     * return -1.  Precondition:  The array must be sorted into increasing
     * order.
     */
    static int binarySearch(int[] A, int loIndex, int hiIndex, int value) {

        if (loIndex > hiIndex) {
            // The starting position comes after the final index,
            // so there are actually no elements in the specified
            // range.  The value does not occur in this empty list!
            return -1;
        }

        else {
            // Look at the middle position in the list.  If the
            // value occurs at that position, return that position.
            // Otherwise, search recursively in either the first
            // half or the second half of the list.
            int middle = (loIndex + hiIndex) / 2;
            if (value == A[middle])
                return middle;
            else if (value < A[middle])
                return binarySearch(A, loIndex, middle - 1, value);
            else   // value must be > A[middle]
                return binarySearch(A, middle + 1, hiIndex, value);
        }

    } // end binarySearch()

}
