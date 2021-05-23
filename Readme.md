# garage
- **Developer**: Yunus Emre AKAN
- **Date**: 23.05.2021
- **Url**: https://github.com/YemreAkan/garage.git

## General Information
Garage is a parking system which allows parked up the vehicles without human intervention. Main target of
Garage is  to be able to manage the parking system as much as the number of parking spaces and generates tickets about parking spaces of vehicles.

## There is 1 controller in the garage project.
- GarageController: Controller is that which gives answers about the status of parking slots and generates tickets about parking spaces of vehicles.

## There are 3 methods in the garage controller.
- **park**: Park method is generates ticket about the vehicles which want to park in the garage slots. If garage has no slot, method says that garage is full. Rules of parking vehicles are that:
- Car holds 1 slot
- Jeep holds 2 slots
- Truck holds 4 slots
- **status**: This method returns the information on the tickets of the vehicles in the slots.
- **leave**: This method empties the desired slot. 

