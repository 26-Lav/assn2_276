document.addEventListener('DOMContentLoaded', function() {
  const deleteLinks = document.querySelectorAll('.delete-link');
  deleteLinks.forEach(function(link) {
    link.addEventListener('click', function(event) {
      event.preventDefault();
      if (confirm('Are you sure you want to delete this student?')) {
        const studentId = this.getAttribute('data-id');
        const csrfToken = this.getAttribute('data-csrf');
        fetch(`/students/delete/${studentId}`, {
          method: 'DELETE',
          headers: {
            'Content-Type': 'application/x-www-form-urlencoded',
            'X-CSRF-TOKEN': csrfToken
          }
        }).then(response => {
          if (response.ok) {
            window.location.reload();
          } else {
            alert('Failed to delete student');
          }
        });
      }
    });
  });
});
