# Aquarium
Aquarium is a console application in which fish can live in threads

# Info
Default values are given in Constants interface in util package

# Rules
- when application starts, there should be some male and female values in aquarium
- each fish should be in separate thread
- fish life duration will be random number
- if two fish encounters, and their gender are different, there should be created new child fish with random gender

# Developer defined rules
- fish aquarium is in 2D size, it means fish can move x and y directions
- fish can move 1 unit to forward, backward and 1 unit to left or right in every 1s
- locationCheckThread checks fishList in every 0.5 s
- if fish amount exceeded from allowed amount, all threads forced to die
