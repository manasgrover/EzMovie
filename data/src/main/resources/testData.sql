insert into tbl_movie(movie_name,release_date,description,rating) values ('RDB',123445,'not good','worst');
insert into tbl_location (city, country, pin_code, state) values ('NEW_DELHI', 'INDIA', '110074', 'DELHI');
insert into tbl_theatre (name, location_id) values ('PVR', 1);
insert into tbl_audi (audi_number, capacity, theatre_id) values (1, 100, 1);
insert into tbl_time_slot (end_time, start_time) values (1510252800000, 1510252200000);
insert into tbl_availabilty (audi_id, time_slot_id, seat_number, date, available, booking_id, movie) values (1, 1, 1, 1510252200000, true, null, 'don'), (1, 1, 2, 1510252200000, true, null, 'don'), (1, 1, 3, 1510252200000, true, null, 'don'), (1, 1, 4, 1510252200000, true, null, 'don'), (1, 1, 5, 1510252200000, true, null, 'don'), (1, 1, 6, 1510252200000, true, null, 'don');
insert into tbl_booking_transaction (user_email, movie_movie_id, booking_status) values ('manasgrover7789@gmail.com', 1, 'BOOKED');
update tbl_availabilty set available = false, booking_id=1 where availability_id in (2, 3, 5);
