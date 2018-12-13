// Copyright (C) 2016 Fan Long, Peter Amidon, Martin Rianrd and MIT CSAIL 
// Genesis (A successor of Prophet for Java Programs)
// 
// This file is part of Genesis.
// 
// Genesis is free software: you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation, either version 2 of the License, or
// (at your option) any later version.
// 
// Genesis is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.
// 
// You should have received a copy of the GNU General Public License
// along with Genesis.  If not, see <http://www.gnu.org/licenses/>.
package ravens;

/** This is a generic exception for Genesis */
public class RavensException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	public RavensException() {
		super();
	}
	public RavensException(String msg) {
		super(msg);
	}
	public RavensException(Throwable e) {
		super(e);
	}
	public RavensException(String msg, Exception e) {
		super(msg, e);
	}
}
