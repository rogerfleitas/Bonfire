public class Bonfire 
{
    public static boolean containsValueAfterIndex(int needle, int [] haystack, int index)
    {
        boolean result = false;

        if (haystack.length == 0)
            return result;

        for (int i = index + 1; i < haystack.length; i++) 
        {
            if (haystack[i] == needle) 
            {
                result = true;
                return result;
            }
        }

        return result;
    }

    public static int getThirdLargest(int [] array)
    {
        int first = 0;
        int second = 0;
        int third = 0;

        if (array.length < 3)
        {
            third = Integer.MIN_VALUE;
            return third;
        }
        
        int i = 0;

        for (i = 0; i < array.length; i++)
        {
            if (array[i] > first)
            {
                first = array[i];
                continue;
            }

            if (array[i] > second && array[i] <= first)
            {
                second = array[i];
                continue;
            }

            if (array[i] > third && array[i] <= second)
            {
                third = array[i];
                continue;
            }
        }

        // In case the array is sorted in order
        // these conditions will set second and third to the appropriate values

        if (second == 0)
            second = array[i - 2];
        
        if (third == 0)
            third = array[i - 3];
        
        return third;
    }

    public static void printThirdLargest(int [] array)
    {
        System.out.println(getThirdLargest(array));
    }

    public static boolean isRotation(int [] array1, int [] array2)
    {
        boolean result = false;
        int count = 0;
        int current = 0;

        // If the two arrays are not matching in length
        // then there is no possible way they can be
        // rotations of one another

        if (array1.length != array2.length)
            return result;

        // we only reach this case if the above condition is not met
        // thus if array1's length is 0, then array2's length must also
        // be 0, meaning it will always evaluate to true

        if (array1.length == 0)
        {
            result = true;
            return result;
        }

        for (int i = 0; i < array1.length; i++)
        {
            current = array1[i];
            
            for (int j = 0; j < array2.length; j++)
            {
                if (current == array2[j])
                {
                    count++;
                    break;
                }
            }
        }

        if (count == array1.length)
            result = true;
        
        return result;
    }

    public static int [] generateNthRotation(int [] array, int n)
    {
        // base case for if the array is empty, and hopefully
        // does not violate the style restriction of
        // only one new array

        if (array.length == 0)
            return new int [0];
        
        int [] result = new int [array.length];

        // mod operator is used here in order to get the proper
        // index to use for our rotation in the for loop

        n = n % array.length;

        // Only allowed to loop through array.length iterations
        // so we will use our modified n value to find the proper
        // spot to begin our rotation and copy it into our new array
        for (int i = 0; i < array.length; i++)
        {
            int position = i + n;

            if (position < 0)
                position = position + array.length;

            if (position >= array.length)
                position = position - array.length;

            result[position] = array[i];
        }

        return result;
    }

    public static double difficultyRating()
    {
        double difficulty = 4.5;
        return difficulty;      
    }

    public static double hoursSpent()
    {
        double hours = 6.8;
        return hours;
    }
}