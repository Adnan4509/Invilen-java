-- ======================================
-- Insert sample data into category table
-- ======================================

INSERT INTO category (name, description) VALUES
('Pain Relief', 'Medicines used to relieve pain and inflammation'),
('Antibiotics', 'Used to treat bacterial infections'),
('Vitamins & Supplements', 'Boost general health and immunity'),
('Cold & Flu', 'Treat symptoms of cold, cough, and flu'),
('Digestive Care', 'For acidity, indigestion, and stomach issues');

-- ======================================
-- Insert sample data into medicine table
-- ======================================

INSERT INTO medicine (name, description, brand, dosage, available_quantity, price, expiry_date, category_id) VALUES

-- Pain Relief
('Paracetamol 500mg', 'Reduces fever and provides relief from mild pain', 'Crocin', '500mg', 200, 35.00, '2026-05-15', 1),
('Ibuprofen 400mg', 'Anti-inflammatory and pain reliever', 'Brufen', '400mg', 150, 65.00, '2026-09-10', 1),
('Diclofenac Gel', 'Topical pain relief gel for joint and muscle pain', 'Voveran', '30g', 100, 95.00, '2027-01-01', 1),
('Aceclofenac 100mg', 'Used to relieve pain and inflammation', 'Hifenac', '100mg', 120, 70.00, '2026-12-20', 1),
('Naproxen 250mg', 'Relieves pain and swelling in joints and muscles', 'Naprosyn', '250mg', 80, 85.00, '2026-08-30', 1),

-- Antibiotics
('Amoxicillin 500mg', 'Treats bacterial infections of ear, throat, and lungs', 'Amoxil', '500mg', 180, 110.00, '2027-03-01', 2),
('Azithromycin 250mg', 'Used for respiratory and skin infections', 'Azithral', '250mg', 160, 130.00, '2026-11-15', 2),
('Ciprofloxacin 500mg', 'Broad spectrum antibiotic', 'Cifran', '500mg', 140, 120.00, '2026-10-01', 2),
('Doxycycline 100mg', 'Treats acne and bacterial infections', 'Doxylin', '100mg', 130, 90.00, '2027-02-28', 2),
('Metronidazole 400mg', 'Used to treat infections caused by bacteria or parasites', 'Flagyl', '400mg', 150, 85.00, '2027-01-10', 2),

-- Vitamins & Supplements
('Vitamin C 500mg', 'Boosts immunity and antioxidant support', 'Celin', '500mg', 250, 95.00, '2027-05-20', 3),
('Vitamin D3 60k IU', 'Supports bone health and calcium absorption', 'D-Rise', '60k IU', 220, 120.00, '2026-09-01', 3),
('Multivitamin Tablets', 'Daily nutritional supplement', 'Revital H', '1 tablet', 300, 180.00, '2027-04-15', 3),
('Iron & Folic Acid Tablets', 'Prevents anemia and supports red blood cell production', 'Livogen', '1 tablet', 200, 130.00, '2027-02-20', 3),
('Calcium + Vitamin D Tablets', 'Promotes strong bones and teeth', 'Shelcal', '500mg', 180, 150.00, '2027-03-25', 3),

-- Cold & Flu
('Cetirizine 10mg', 'Relieves allergy, sneezing, and runny nose', 'Cetzine', '10mg', 300, 45.00, '2026-12-15', 4),
('Paracetamol + Caffeine', 'Used for cold, headache, and mild fever', 'D-Cold Total', '1 tablet', 250, 90.00, '2027-01-20', 4),
('Ambroxol + Guaifenesin Syrup', 'Cough expectorant for chest congestion', 'Mucosolvan', '100ml', 120, 110.00, '2026-10-10', 4),
('Steam Inhalant Capsule', 'Provides relief from nasal congestion', 'Karvol Plus', '1 capsule', 200, 75.00, '2027-06-01', 4),
('Diphenhydramine Syrup', 'Cough suppressant syrup', 'Benadryl', '100ml', 100, 115.00, '2026-09-05', 4),

-- Digestive Care
('Pantoprazole 40mg', 'Reduces stomach acid and treats acidity', 'Pantocid', '40mg', 180, 85.00, '2026-08-30', 5),
('Omeprazole 20mg', 'Treats acidity and heartburn', 'Omez', '20mg', 200, 75.00, '2027-02-01', 5),
('Domperidone 10mg', 'Relieves nausea and vomiting', 'Domstal', '10mg', 160, 80.00, '2026-11-10', 5),
('Digene Tablets', 'Antacid tablets for gas and acidity relief', 'Digene', '1 tablet', 250, 60.00, '2027-05-15', 5),
('ORS Solution', 'Rehydrates body and restores electrolytes', 'Electral', '21g sachet', 150, 35.00, '2026-09-15', 5);
