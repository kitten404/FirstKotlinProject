import models.Leilao
import models.Produto
import models.Usuario

fun main(){

    val produto = Produto(1,"Alianca de Ouro")
    val produto2 = Produto(2,"Carrinho de Bebê")
    val user = Usuario(1,"Ana Maria")
    val user2 = Usuario(2,"Juliete")
    val user3 = Usuario(3,"Marilda")
    val user4 = Usuario(3,"Joelma")
    val user5 = Usuario(3,"Edvanio")
    val lance = Leilao(1, 2900.00,user,produto)
    val lance2 = Leilao(2, 2300.00,user2,produto)
    val lance3 = Leilao(3, 10000.00,user3,produto)
    val lance4 = Leilao(3, 10.00,user4,produto)
    val lance5 = Leilao(3, 910.00,user5,produto)

    val lancec = Leilao(1, 190.00,user,produto2)
    val lancec2 = Leilao(2, 200.00,user2,produto2)
    val lancec3 = Leilao(3, 250.00,user3,produto2)
    val lancec4 = Leilao(3, 410.00,user3,produto2)
    val lancec5 = Leilao(3, 189.00,user3,produto2)
    val list = listOf(lance,lance2,lance3,lance4,lance5, lancec,lancec2,lancec3,lancec4,lancec5);

    maiorLance(list)
    lancesDoProduto(produto, list)
    lancesDoProduto(produto2, list)



}
fun maiorLance(lances : Collection<Leilao>){
    var maior: Double = 0.0
    var maiorLance: Leilao = Leilao(1,0.0,Usuario(0,""), Produto(1,""))
    for (lance in lances){
        if(lance.valor > maior) {
            maior = lance.valor
            maiorLance = lance
        }
    }

    println("O maior Lance foi de "+maiorLance.Usuario.nome +" no valor de R$"+maiorLance.valor+",levando então pra casa "+ maiorLance.produto.nome )
}

fun lancesDoProduto(produto:Produto, lances: Collection<Leilao>){
    var leilao : List<Leilao> = mutableListOf<Leilao>()
    println("Os lances do produto "+ produto.nome+" foram:")
    for(lance in lances){
        if(lance.produto == produto){
            leilao+=lance
            println(lance.Usuario.nome)
        }
    }
}