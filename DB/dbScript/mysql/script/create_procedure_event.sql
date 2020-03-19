use feelview;

set global event_scheduler=1;

drop event if exists sp_removeCmlHis_event;

Delimiter //
Create event sp_removeCmlHis_event
On schedule
Every 1 DAY
Starts  '2014-05-06 02:00:00'
Do
Begin
  call sp_removeCmlHis();
End;
//
Delimiter ;