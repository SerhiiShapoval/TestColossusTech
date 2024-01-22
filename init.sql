CREATE TABLE IF NOT EXISTS warehouse (
                                         id SERIAL PRIMARY KEY,
                                         name VARCHAR(50) NOT NULL,
                                         address_line_1 VARCHAR(100) NOT NULL,
                                         address_line_2 VARCHAR(100),
                                         city VARCHAR(50) NOT NULL,
                                         state VARCHAR(50) NOT NULL,
                                         country VARCHAR(50) NOT NULL,
                                         inventory_quantity INT NOT NULL DEFAULT 0
);

INSERT INTO warehouse (name, address_line_1, address_line_2, city, state, country, inventory_quantity)
VALUES
    ('Central Storage', '123 Main Street', 'Suite 101', 'City A', 'State X', 'Country 1', 150),
    ('Global Warehousing', '456 Oak Avenue', 'Floor 2', 'Town B', 'State Y', 'Country 2', 200),
    ('Urban Logistics', '789 Maple Street', '', 'City C', 'State Z', 'Country 3', 100),
    ('Metropolis Warehouse', '987 Pine Avenue', 'Unit 201', 'Metropolis D', 'State W', 'Country 4', 300),
    ('City Storage Solutions', '654 Elm Street', 'Apartment 301', 'Town E', 'State V', 'Country 5', 250),
    ('Village Distribution Center', '321 Birch Street', 'Suite 102', 'Village F', 'State U', 'Country 6', 180),
    ('Rural Supply Depot', '101 Cedar Avenue', 'Cottage 3', 'Rural G', 'State T', 'Country 7', 220),
    ('Mega Logistics Complex', '234 Oak Avenue', 'Floor 4', 'City H', 'State S', 'Country 8', 170),
    ('Main Logistics Hub', '876 Pine Street', 'Suite 501', 'Metropolis J', 'State Q', 'Country 9', 280),
    ('International Distribution Center', '543 Cedar Avenue', 'Unit 601', 'Global City K', 'State P', 'Country 10', 320),
    ('City Logistics Terminal', '789 Elm Street', 'Apt 202', 'City L', 'State O', 'Country 11', 180),
    ('Suburban Warehouse', '654 Birch Avenue', 'Floor 3', 'Suburb M', 'State N', 'Country 12', 230),
    ('Coastal Supply Depot', '321 Cedar Street', 'Suite 303', 'Coastal City N', 'State M', 'Country 13', 280),
    ('Mountain Storage Facility', '101 Oak Avenue', 'Unit 402', 'Mountain Town O', 'State L', 'Country 14', 150),
    ('City Logistics Center', '234 Pine Street', 'Apt 501', 'City P', 'State K', 'Country 15', 320),
    ('Regional Distribution Hub', '876 Elm Avenue', 'Floor 2', 'Regional Center Q', 'State J', 'Country 16', 270),
    ('Northern Logistics Terminal', '543 Birch Street', 'Cottage 4', 'Northern City R', 'State I', 'Country 17', 200),
    ('City Distribution Facility', '789 Oak Avenue', 'Suite 601', 'City S', 'State H', 'Country 18', 180),
    ('Central Distribution Warehouse', '654 Cedar Street', 'Unit 302', 'Central City T', 'State G', 'Country 19', 250),
    ('City Supply Chain Hub', '321 Oak Street', 'Floor 3', 'City U', 'State F', 'Country 20', 300),
    ('Global Logistics Center', '101 Pine Avenue', 'Apt 402', 'Global City V', 'State E', 'Country 21', 210),
    ('City Storage Depot', '234 Elm Avenue', 'Suite 501', 'City W', 'State D', 'Country 22', 180),
    ('Urban Supply Depot', '876 Birch Street', 'Unit 302', 'Urban City X', 'State C', 'Country 23', 230),
    ('City Distribution Warehouse', '543 Pine Avenue', 'Floor 2', 'City Y', 'State B', 'Country 24', 280),
    ('Metropolitan Logistics Terminal', '789 Elm Street', 'Apt 401', 'Metropolis Z', 'State A', 'Country 25', 150),
    ('Coastal Distribution Center', '654 Oak Avenue', 'Suite 501', 'Coastal City AA', 'State BB', 'Country 26', 320),
    ('Suburban Storage Solutions', '321 Pine Street', 'Unit 202', 'Suburb CC', 'State DD', 'Country 27', 270),
    ('City Logistics Hub', '101 Elm Avenue', 'Floor 3', 'City EE', 'State FF', 'Country 28', 200),
    ('City Logistics Terminal', '234 Cedar Street', 'Apt 402', 'City GG', 'State HH', 'Country 29', 180),
    ('Global Distribution Facility', '876 Oak Avenue', 'Suite 501', 'Global City II', 'State JJ', 'Country 30', 250);




