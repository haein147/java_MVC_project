
insert into customer values('이해인', 'dlgodls147', '010-7110-4931',
			'1002-431-508116 우리은행', 20);
insert into customer values('서동호', 'tjehdgh', '010-4931-3804',
			'1234-0000-2344 카카오뱅크', 30);
insert into customer values('김은지', 'rladmswl', '010-1234-1234',
			'1002-000-123456 우리은행', 20);	
insert into customer values('황윤후', 'ghkddbsgn', '010-9876-9876',
			'7110-431-54321 신한은행', 20);

insert into room values('하늘방', 4,'Yes');
insert into room values('구름방', 4, 'Yes');
insert into room values('호수방', 12, 'Yes');
insert into room values('별빛방', 4, 'No');


insert into pay values(002, '카드결제','120000');
insert into pay values(003, '현금결제','200000');
insert into pay values(004, '네이버페이','100000');
insert into pay values(005, '카드결제','50000');


insert into reserve values(0001, '이해인', '18/10/24', '야놀자','하늘방', 002);
insert into reserve values(0002, '서동호', '18/10/27', '홈페이지','구름방', 003);
insert into reserve values(0003, '김은지', '18/11/04', '소셜', '호수방', 004);
insert into reserve values(0004, '황윤후', '18/11/11', '야놀자', '별빛방',005);

commit;