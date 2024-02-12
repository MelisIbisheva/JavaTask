using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Welcome.Others;

namespace welcome.Model
{
    class User
    {
        private string name;
        private string password;
        private UserRolesEnum role;

        public string Name
        {
            get { return name; }
            set { name = value; }
        }

        public string Password
        {
            get { return password; }
            set { password = value; }
        }

        public UserRolesEnum Role
        {
            get { return role; }
            set { role = value; }
        }

    
    }
}
