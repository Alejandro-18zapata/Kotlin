
enum class Rol {
    ADMIN, EDITOR, VISITANTE
}
interface Autenticable {
    fun autenticar(pass: String): Boolean
}
data class Usuario(
    val nombre: String,
    val rol: Rol,
    private val clave: String) : Autenticable {
    override fun autenticar(pass: String): Boolean {
        return clave == pass }}
object GestorUsuarios {
    private val usuarios = mutableListOf<Usuario>()
    fun agregar(u: Usuario) {
        usuarios.add(u) }
    fun validarRol(u: Usuario) {
        when (u.rol) {
            Rol.ADMIN -> println("ADMIN: acceso total")
            Rol.EDITOR -> println("EDITOR: puede editar")
            Rol.VISITANTE -> println("VISITANTE: solo ver")}  }}
fun main() {

    val admin = Usuario("Ana", Rol.ADMIN, "1234")
    GestorUsuarios.agregar(admin)
    GestorUsuarios.validarRol(admin)
    println("Autenticación correcta: ${admin.autenticar("1234")}")
    println("Autenticación incorrecta: ${admin.autenticar("5678")}")
}
