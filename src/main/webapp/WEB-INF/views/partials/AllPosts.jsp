			
			<%@page import="java.util.concurrent.TimeUnit"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@page import="loggy.entities.Post"%>
			<%
				 List<Post> allPosts = (List<Post>) request.getAttribute("allPosts");
			
				for(Post post: allPosts){	
					
					// Get the current time
					  Date currentTime = new Date();

					  // Assuming yourDate is the Date object you want to display
					  Date yourDate = post.getUpload_date(); // Provide your Date object here

					  // Calculate the time difference in milliseconds
					  long timeDiffInMillis = currentTime.getTime() - yourDate.getTime();
						
					  // Calculate the time difference in minutes, hours, and days
					  long minutesDiff = timeDiffInMillis / 1000;
					  long hoursDiff = TimeUnit.MILLISECONDS.toHours(timeDiffInMillis);
					  long daysDiff = TimeUnit.MILLISECONDS.toDays(timeDiffInMillis);

					  // Choose the appropriate time unit to display
					  String timeAgo;
					  if (minutesDiff < 60) {
					    timeAgo = minutesDiff + " min ago";
					  } else if (hoursDiff < 24) {
					    timeAgo = hoursDiff + " hour ago";
					  } else {
					    timeAgo = daysDiff + " day ago";
					  }
					
					  System.out.print(yourDate+ "    \n");
					  // Format the original date as desired
// 					  SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
// 					  String formattedDate = formatter.format(yourDate);
				
					
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
							<span class="text-muted pl-3"><%=timeAgo %></span>
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