
This application analyses an input CSV file containing mobile loan data and produces the sum of loan amounts as well as loan counts
per network, product, month tuple. 

Unfortunately what makes up a tuple is fixed at the moment at (Network, Product, Month).

The application was developed in Java to make use of modern OO design principles.

The project makes use of the Maven build manager from Apache and requires Java SE8. 

In order to build the application a working Maven installation is required. 

The following steps should be followed to use the application:


git clone https://github.com/snymanth/loan_accounting.git

cd into the folder created

run "mvn clean install"

A jar file should be created in the following relative path: "/target"

Copy the jar file to a location of choice.

Run the application with the following command: java -jar "Path-to-copied-jar-file" "Path-to-csv-file-containing-loan-data"

The application will create file in the current working directory called "Outputs.csv" containing the analyses results.
