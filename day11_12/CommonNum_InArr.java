package day11_12;

public class CommonNum_InArr {

	public static void main(String[] args) {
    //to print the common numbers inbetween two arrays
int[] array1 = { 1, 2, 5, 5, 8, 9, 7, 10 };
int[] array2 = { 1, 0, 6, 15, 6, 4, 7, 0 };

System.out.println("-------------method-1-----------");
for(int i = 0 ; i<array1.length ; i++)
{
	for(int j = 0 ; j<array2.length ; j++)
	{
		if(array1[i] == array2[j])
		{
			System.out.println("Common element " + array1[i]);
		}
	}
}

System.out.println("------------Method-2-----------------");
for(int eachNum : array1)
{
	for(int j = 0 ; j<array2.length;j++)
	{
		if(eachNum == array2[j])
		{
			System.out.println("common element " + eachNum);
		}
	}
}

	}

}
