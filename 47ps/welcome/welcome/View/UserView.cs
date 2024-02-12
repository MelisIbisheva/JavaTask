using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using welcome.ViewModel;
namespace welcome.View
{
    class UserView
    {
        private UserViewModel _viewModel;

        public UserView(UserViewModel viewModel) {
            _viewModel = viewModel;
        }

        public void Disply()
        {
            Console.WriteLine("User: ");
        }

    }
}
