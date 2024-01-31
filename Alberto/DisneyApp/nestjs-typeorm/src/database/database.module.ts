import { Module, Global } from '@nestjs/common';
import {Client} from 'pg';
const API_KEY = '12345634';
const API_KEY_PROD = 'PROD1212121SA';

const client = new Client({
  user: 'bryanjd',
  host: 'frutiz.c5yaymocixgj.us-east-1.rds.amazonaws.com',
  database: 'postgres',
  password: 'bryanbryan',
  port: 5432,
  ssl:true
});

client.connect();
client.query('SELECT * FROM task ORDER BY id_task ASC', (err, res) => {
  //console.error(err);
  console.log(res.rows);
});

@Global()
@Module({
  providers: [
    {
      provide: 'API_KEY',
      useValue: process.env.NODE_ENV === 'prod' ? API_KEY_PROD : API_KEY,
    },
    {
      provide: 'PG',
      useValue: client,
    }
  ],
  exports: ['API_KEY', 'PG'],
})
export class DatabaseModule {}
