
		<!-- Write the blog Starts -->
		<div class="w-100">
			<div type="button" data-toggle="modal" data-target="#exampleModal">
				Write a blog
			</div>
		</div>
		<!-- Modal -->
		<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="false">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Create Post</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			
			<!-- Write Blog here -->
			<div class="modal-body">
		        <form action="write-post" method="post" enctype="multipart/form-data" >
		        	<div>
		        		<label class="p-0">Title</label> <small class="text-muted">max length 60 char</small>
		        	</div>
		        	<input class="form-control mb-2" name="title" placeholder="Title here" maxlength="60">
		        	<br>
		        	<div>
		        		<label class="p-0">Description</label> <small class="text-muted">max length 120 char</small>
		        	</div>
		     		<textarea class="form-control mb-2" name="content" rows="" cols="" placeholder="Write the content..."></textarea>		        	
		        	 <div class="form-group">
					    <label for="exampleInputEmail1" class="mb-0">Add Attachment</label>
					    <input type="file" name="file" class="form-control">					    
					  </div>
					 <input type="submit" value="Post" class="btn btn-primary w-100">
		        </form>
		     </div>		      
		    </div>
		  </div>
		</div>
		<!-- Write blog Ends -->