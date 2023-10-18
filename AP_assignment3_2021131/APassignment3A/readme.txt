I tried all different combinations of no. of threads and foud that the code is giving best output while running on 2 threads.

Infact we can see thst as array size increases gap between execution time is decreases and has decreased to almost close to 1 sec while performing sort on array size of 1 lakh.

And infact in some  places parallel algorithim performed better than non- parallel.

-------------------------------------------------

To run Part-A->

Open cmd  and change directory to the folder APassignment3A in the submision folder and run the following command one by one ->

	mvn package

	java -cp target/APassignment3A-1.0-SNAPSHOT.jar assignment3AP.Main
