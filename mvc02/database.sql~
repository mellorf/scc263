create table tbDirectory (
	inode serial not null primary key,
	iparent integer not null,
	name varchar(255) not null
);

create table tbDropFile (
	inode serial not null primary key,
	name varchar(255) not null,
	mimetype varchar(255) not null,
	iparent integer not null references tbDirectory(inode),
	size integer not null
);

create table tbUser (
	email varchar(255) not null primary key,
	name varchar(255) not null,
	password varchar(32) not null,
	freespace integer not null,
	space integer not null,
	inode integer not null references tbDirectory(inode)
);

create unique index dropfile_unique on tbdropfile(iparent, name);
