package pterodactyle.coeur2;

import pterodactyle.echangeable.Tag;
import pterodactyle.echangeable._Echangeable;
import pterodactyle.utilisateur.Utilisateur;

public class VerifAutorisation implements _VerifAutorisation {

	@Override
	public boolean lecture(_Echangeable echangeable, Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean ecriture(_Echangeable echangeable, Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean partage(_Echangeable echangeable, Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean creation(_Echangeable echangeable, Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean suppression(_Echangeable echangeable, Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean lectureTag(Tag tag, Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean ecritureTag(Tag tag, Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean partageTag(Tag tag, Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean creationTag(Tag tag, Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean suppressionTag(Tag tag, Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		return false;
	}

}
