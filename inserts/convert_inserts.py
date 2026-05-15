import os
import glob
import re

def process_file(filepath, outdir):
    filename = os.path.basename(filepath)
    with open(filepath, 'r') as f:
        content = f.read()

    # Replacements
    # 1. Subsidios booleans
    if filename == 'InsertSubsidios.sql':
        content = re.sub(r'VALUES\s*\((0),\s*0,\s*8\),\s*\((1),\s*10,\s*9\),\s*\((1),\s*25,\s*10\);', 
                         r'VALUES (false, 0, 8), (true, 10, 9), (true, 25, 10);', content)
        # just in case it doesn't match perfectly:
        content = content.replace('(0, 0, 8)', '(false, 0, 8)')
        content = content.replace('(1, 10, 9)', '(true, 10, 9)')
        content = content.replace('(1, 25, 10)', '(true, 25, 10)')

    # 2. INSERT OR IGNORE INTO
    # For Roles
    content = re.sub(r'INSERT\s+OR\s+IGNORE\s+INTO\s+roles\b', r'INSERT INTO Roles', content, flags=re.IGNORECASE)
    content = re.sub(r'(INSERT\s+INTO\s+Roles\s+\([^)]+\)\s+VALUES\s+.*?);', r'\1 ON CONFLICT (id) DO NOTHING;', content, flags=re.IGNORECASE)

    # For Users
    content = re.sub(r'INSERT\s+OR\s+IGNORE\s+INTO\s+Users\b', r'INSERT INTO Users', content, flags=re.IGNORECASE)
    content = re.sub(r'(INSERT\s+INTO\s+Users\s+\([^)]+\)\s+VALUES\s+.*?);', r'\1 ON CONFLICT (username) DO NOTHING;', content, flags=re.IGNORECASE)

    # For Combustibles
    content = re.sub(r'INSERT\s+OR\s+IGNORE\s+INTO\s+Combustibles\b', r'INSERT INTO Combustibles', content, flags=re.IGNORECASE)
    content = re.sub(r'(INSERT\s+INTO\s+Combustibles\s+\([^)]+\)\s+VALUES\s+.*?);', r'\1 ON CONFLICT (id) DO NOTHING;', content, flags=re.IGNORECASE)

    # For Reglas
    content = re.sub(r'INSERT\s+OR\s+IGNORE\s+INTO\s+Reglas\b', r'INSERT INTO Reglas', content, flags=re.IGNORECASE)
    content = re.sub(r'(INSERT\s+INTO\s+Reglas\s+\([^)]+\)\s+VALUES\s+.*?);', r'\1 ON CONFLICT (tipo_vehiculo) DO NOTHING;', content, flags=re.IGNORECASE)

    # For everything else, just replace INSERT OR IGNORE INTO with INSERT INTO
    content = re.sub(r'INSERT\s+OR\s+IGNORE\s+INTO', 'INSERT INTO', content, flags=re.IGNORECASE)

    # Fix table names case if needed (PostgreSQL is case-insensitive for unquoted, but better safe)
    # The regex above mostly preserved the original names.

    # 3. Add comments indicating conversion
    comment = "-- Script convertido para PostgreSQL\n"
    content = comment + content

    with open(os.path.join(outdir, filename), 'w') as f:
        f.write(content)
    
    print(f"Processed {filename}")

if __name__ == '__main__':
    if not os.path.exists('new-sql'):
        os.makedirs('new-sql')
    
    for filepath in glob.glob('old-sql/Insert*.sql'):
        process_file(filepath, 'new-sql')
