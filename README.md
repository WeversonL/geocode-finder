# geocode-finder

### Java to consumes Google Maps API's

API developed for consumption of Google Maps API's to search coordinates. Made for study and practice purposes! And of course, to help me with daily research!

## Get Started

### Setting up environment

1. To use, a Key API provided by Google is required to consume Google Maps APIs. [Follow this step by step.](https://developers.google.com/maps/documentation/elevation/cloud-setup?hl=en)

2. When running the API, be sure to export your environment variable with the Key API, or change the source code for that. An example of exporting the Key API and executing the project on your shell would be:

        export API_KEY=ABCDEFG
        mvn spring-boot:run 

### Running the application with Docker

Make sure you have Docker installed on your machine. [Dockerhub](https://hub.docker.com/r/weversonlemos/geocode-finder)

1. Clone the image

        docker pull weversonlemos/geocode-finder:latest

2. Start container with image and api key

        docker run -p 8080:8080 --name geocode-finder -e API_KEY=YOUR_API_KEY weversonlemos/geocode-finder:latest

3. To obtain the coordinates of an address, below is an example curl. The string need not be coded for the search, the program is already in charge of doing this

        curl --location 'http://localhost:8080/address/geocode?address=Morumbi%2C%20S%C3%A3o%20Paulo'

### Execute source code with maven

Make sure you have Java and Maven installed on your machine.

1. Clone the repository or download the source code

        git clone https://github.com/WeversonL/geocode-finder.git
        cd geocode-finder

2. Download maven dependencies

        mvn clean install

3. Run the Spring Boot project

        mvn spring-boot:run

4. To obtain the coordinates of an address, below is an example curl. The string need not be coded for the search, the program is already in charge of doing this

        curl --location 'http://localhost:8080/address/geocode?address=Morumbi%2C%20S%C3%A3o%20Paulo'

### Compile source code with maven

Make sure you have Java and Maven installed on your machine.

1. Clone the repository or download the source code

        git clone https://github.com/WeversonL/geocode-finder.git
        cd geocode-finder

2. Download maven dependencies and build package

        mvn clean install
        mvn clean package

3. Run the Jar File

        java -jar target/app.jar

4. To obtain the coordinates of an address, below is an example curl. The string need not be coded for the search, the program is already in charge of doing this

        curl --location 'http://localhost:8080/address/geocode?address=Morumbi%2C%20S%C3%A3o%20Paulo'

⚠️ Still in development

## License

`geocode-finder` is released under the [GNU General Public License, Version 2](LICENSE)
    
        Copyright (C) 2022 Weverson Lemos

        This program is free software; you can redistribute it and/or
        modify it under the terms of the GNU General Public License
        as published by the Free Software Foundation; either version 2
        of the License, or (at your option) any later version
