##Capstone Project for J2EE Java Training Batch

#Blog Application

This is a Blog Application which consist of Various methods related to Blog Application like as
- Post Blog
- Update Blog
- Get Blog
- Delete Blog
- Post Comment

It uses two separate tables of MYSQL Database locally 
- Blogs
- Comments

Post Blog - It is a create method which creates a New Blog in the Database with id, title and content.
ID - It is a self generating column with Identity Type, which means it follows a sequence of Numbers by itself unique for each row. As it is also considered as the Primary Key
TITLE - It is a column which takes data as Title of Blog in String format with constaints of NotBlank and Size(3 to 100 characters).
Content - It is a column which takes data as Content of Blog in String format with constraints of NotBlank and Size(3 to 200 characters).

Update Blog - It is a update method which updates the existing Blog in the Database with title and content using Id as finding key.

Get Blog - It is a fetching method which fetches the data from the Blog Database of the existing Blog using Id as finding key.

Delete Blog - It is a deleting method which deleted the data of a particular Blog from the Blog Database using Id as finding key.

Post Comment - It is a create method which create a New Comment in the Database with id, blogid and comment.
              It will create a comment on when an existing Blog is present in the Blogs database which is checked using BlogId.
