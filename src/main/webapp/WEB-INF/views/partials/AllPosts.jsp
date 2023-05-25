			
			<%@page import="java.util.List"%>
<%@page import="loggy.entities.Post"%>
			<%
				 List<Post> allPosts = (List<Post>) request.getAttribute("allPosts");
			
				for(Post post: allPosts){	
					
				
					
			%>

			<div class="content-box">
				<a href="profile">
					<div class="content-header-info d-flex align-items-center">
						<!-- user image -->
						<img class="content-owner-image p-1" src="resources/image/user.jpg"
							alt="user">
	
						<!-- user info -->
						<div class="">
							<span class="font-weight-bold pl-3"><%=post.getUser().getName() %></span> <br>
							<span class="text-muted pl-3">5:10 pm &nbsp; 31 May, 2020</span>
						</div>
					</div>
				</a>
				<!-- content text -->
				<div class="content-text my-3">
					<h4><%=post.getTitle() %></h4>
					<p><%=post.getContent() %></p>
				</div>
				
				
				
				<%
					if(post.getPostMultimedia() != null){										
						String media_type = post.getPostMultimedia().getMedia_type();
						String media_path = post.getPostMultimedia().getPath();		

				%>	
				
				
				<!-- content-multimedia -->
				<div class="content-multimedia">
					<h1><%=media_type %></h1>
					<%
						if(media_type.equals("video")){
							%>
								<video class="card-img" controls>
								  <source src="resources/post_files/<%=media_path %>" type="video/mp4">
								  You browser does not support this video
								</video>
								
							<%
						}else{
							%>
								<img class="card-img" src="resources/post_files/<%=media_path %>" alt="POST">						
							<% 
						}
					%>
				</div>
				<%
					} 
				%>
				
				<!-- content interaction -->
				<div class="content-interaction">
					<button>
						<i class="fa-regular fa-heart p-1"></i> Love
					</button>
					<a href=""><i class="fa-sharp fa-regular fa-comment p-1"></i>
						Comment</a>
					<button>Share</button>
				</div>
			</div>
			<%
			}
			%>