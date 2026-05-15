-- Script convertido para PostgreSQL
INSERT INTO Reglas (tipo_vehiculo, precio, fecha, admin_id) VALUES ('Servicio particular', 10000, '2026-03-01', 2) ON CONFLICT (tipo_vehiculo) DO NOTHING;
INSERT INTO Reglas (tipo_vehiculo, precio, fecha, admin_id) VALUES ('Oficiales', 8000, '2026-03-01', 2) ON CONFLICT (tipo_vehiculo) DO NOTHING;
INSERT INTO Reglas (tipo_vehiculo, precio, fecha, admin_id) VALUES ('Diplomáticos', 1000, '2026-03-01', 2) ON CONFLICT (tipo_vehiculo) DO NOTHING;
INSERT INTO Reglas (tipo_vehiculo, precio, fecha, admin_id) VALUES ('Camperos y Cuatrimotos', 12000, '2026-03-01', 2) ON CONFLICT (tipo_vehiculo) DO NOTHING;
INSERT INTO Reglas (tipo_vehiculo, precio, fecha, admin_id) VALUES ('Subsidiado', 5000, '2026-03-01', 2) ON CONFLICT (tipo_vehiculo) DO NOTHING;