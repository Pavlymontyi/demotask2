<a href = "/person">Spenders</a>
<a href = "/category">Expense Categories</a>
<a href = "/expense">Expenses</a>

<div id="header">
    <h2>Expenses</h2>
</div>
<div id="content">
    <fieldset>
        <legend>Add New Expense</legend>
        <form name="expense" action="/expense" method="post">
            Description : <input type="text" name="description" /><br/>
            Amount : <input type="text" name="amount" /><br/>
            Person : <input type="text" name="person_id" /><br/>
            Category : <input type="text" name="category_id" /><br/>
            <input type="submit" value="Save" />
        </form>
    </fieldset>

    <table class="datatable">
        <tr>
            <th>Description</th>
            <th>Amount</th>
            <th>Person</th>
            <th>Category</th>
        </tr>
        <#list model["expenses"] as expense>
            <tr>
                <td>${expense.description}</td>
                <td>${expense.amount}</td>
                <td><a href="person/${expense.person.id!}">${expense.person.name!}</a></td>
                <td><a href="category/${expense.category.id!}">${expense.category.name!}</a></td>
            </tr>
        </#list>
    </table>

</div>