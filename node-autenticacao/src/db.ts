import { Pool } from "pg";

const connectionString = '';

const db = new Pool({ 
  user: 'postgres',
  host: 'localhost',
  database: 'dbautenticacao',
  password: 'postgres',
  port: 5432,
 });

export default db;