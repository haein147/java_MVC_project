
insert into customer values('������', 'dlgodls147', '010-7110-4931',
			'1002-431-508116 �츮����', 20);
insert into customer values('����ȣ', 'tjehdgh', '010-4931-3804',
			'1234-0000-2344 īī����ũ', 30);
insert into customer values('������', 'rladmswl', '010-1234-1234',
			'1002-000-123456 �츮����', 20);	
insert into customer values('Ȳ����', 'ghkddbsgn', '010-9876-9876',
			'7110-431-54321 ��������', 20);

insert into room values('�ϴù�', 4,'Yes');
insert into room values('������', 4, 'Yes');
insert into room values('ȣ����', 12, 'Yes');
insert into room values('������', 4, 'No');


insert into pay values(002, 'ī�����','120000');
insert into pay values(003, '���ݰ���','200000');
insert into pay values(004, '���̹�����','100000');
insert into pay values(005, 'ī�����','50000');


insert into reserve values(0001, '������', '18/10/24', '�߳���','�ϴù�', 002);
insert into reserve values(0002, '����ȣ', '18/10/27', 'Ȩ������','������', 003);
insert into reserve values(0003, '������', '18/11/04', '�Ҽ�', 'ȣ����', 004);
insert into reserve values(0004, 'Ȳ����', '18/11/11', '�߳���', '������',005);

commit;